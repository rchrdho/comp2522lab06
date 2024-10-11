import java.util.*;

/**
 * The {@code BookStore} class represents a store containing a collection of novels.
 * It provides methods to search, sort, and print information about the novels.
 *
 * @author Bryson Lindy
 * @author Richard Ho
 * @author Phyo Thu Kha
 *
 * @version 1.0
 */
public class BookStore<T extends Literature>
{
    private static final int ROUND_LOWER_BOUND    = 10;
    private static final int ROUND_UPPER_BOUND    = 9;
    private static final int PERCENTAGE_CONVERTOR = 100;

    private final String             storeName;
    private final List<Novel>        novels;
    private final Map<String, Novel> novelsMap;
    private final Set<String>        keySet;
    private final List<String>       keyList;
    private final List<T>            items;

    /**
     * Constructs a {@code BookStore} with the given store name.
     * Initializes the list of novels using {@code Novel.createNovelList()}.
     *
     * @param storeName the name of the bookstore
     */
    public BookStore(final String storeName)
    {
        validateName(storeName);

        this.storeName = storeName;
        this.novels    = Novel.createNovelList();

        this.novelsMap = new HashMap<>();
        insertNovelsMap(novelsMap);

        this.keySet    = novelsMap.keySet();
        this.keyList   = new ArrayList<>(keySet);
        items          = new ArrayList<>();
        Collections.sort(keyList);
    }

    /**
     * Returns the name of the bookstore.
     *
     * @return the name of the bookstore
     */
    public String getStoreName()
    {
        return storeName;
    }

    /*
    Checks to make sure the store name is not null or empty.
     */
    private static void validateName(final String storeName)
    {
        if(storeName == null || storeName.isEmpty())
        {
            throw new IllegalArgumentException("Store name cannot be null or empty");
        }
    }

    /*
     * Helper method to populate hashmap with Novels
     */
    private void insertNovelsMap(final Map<String, Novel> novelMap)
    {
        final boolean emptyNovelMap = novelMap.isEmpty();

        if(novelMap != null && emptyNovelMap)
        {
            for(Novel novel : novels)
            {
                novelMap.put(novel.getTitle(), novel);
            }
        }
    }

    /**
     * Iterates through the BookStore List and prints all the titles in UPPERCASE.
     */
    public void printAllTitles()
    {
        for(Novel novel : novels)
        {
            final String titleUpperCase;

            titleUpperCase = novel.getTitle().toUpperCase();

            System.out.println(titleUpperCase);
        }
    }

    /**
     * Iterates through the BookStore List and prints all titles that contain the
     * parameter passed as a String.
     *
     * @param title what we check to see if each title in the book store list contains
     */
    public void printBookTitle(final String title)
    {
        String titleLowerCase;

        titleLowerCase = title.toLowerCase();

        for(Novel novel : novels)
        {
            final String novelTitleLowerCase;

            novelTitleLowerCase = novel.getTitle().toLowerCase();

            if(novelTitleLowerCase.contains(titleLowerCase))
            {
                System.out.println(novel.getTitle());
            }
        }
    }

    /**
     * Creates a copy of the instance List of Books. Sorts the copy and then
     * prints all of them in alphabetical order.
     */
    public void printTitlesInAlphaOrder()
    {
        List<Novel> sortedBooks;

        sortedBooks = new ArrayList<>(novels);
        Collections.sort(sortedBooks);

        for(Novel novel : sortedBooks)
        {
            System.out.println(novel.getTitle());
        }
    }

    /**
     * Prints all the novels published in a decade determined by the passed int parameter.
     * Takes a given decade parameter and rounds it down to the nearest {@value ROUND_LOWER_BOUND} to determine
     * the lower bound of the decade. Then adds {@value ROUND_UPPER_BOUND}
     *
     * @param decade a year that falls in the desired decade
     */
    public void printGroupByDecade(final int decade)
    {
        int startOfDecade;
        int endOfDecade;
        int publicationYear;

        startOfDecade = (decade/ ROUND_LOWER_BOUND) * ROUND_LOWER_BOUND;
        endOfDecade   = startOfDecade + ROUND_UPPER_BOUND;

        for(Novel novel : novels)
        {
            publicationYear = novel.getYearPublished();

            if(publicationYear >= startOfDecade && publicationYear <= endOfDecade)
            {
                System.out.println(novel.getTitle());
            }
        }
    }

    /**
     * Initializes the longestTitle variable to the first book in the book list.
     * Iterates through all novels to find the longest title and prints the result.
     */
    public void printLongest()
    {
        String longestTitle;

        longestTitle = novels.getFirst().getTitle();

        for(Novel novel : novels)
        {
            final int novelTitleLength;
            final int longestNovelTitleLength;

            novelTitleLength = novel.getTitle().length();
            longestNovelTitleLength = longestTitle.length();

            if(novelTitleLength > longestNovelTitleLength)
            {
                longestTitle = novel.getTitle();
            }
        }

        System.out.println(longestTitle);
    }

    /**
     * Iterates through the book list to see if any were published in the year passed
     * as a parameter. Returns true if one is found, false if not.
     *
     * @param year to check if
     * @return boolean
     */
    public boolean isThereABookWrittenIn(final int year)
    {
        for(Novel novel : novels)
        {
            final int novelYearPublished;

            novelYearPublished = novel.getYearPublished();

            if(novelYearPublished == year)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Increments a counter for each title in the book list that contains the
     * word passed as a parameter.
     *
     * @param word String to check if contained in each book title
     * @return number
     */
    public int howManyBooksContain(final String word)
    {
        int          counter;
        final String wordLowerCase;

        counter       = 0;
        wordLowerCase = word.toLowerCase();

        for(Novel novel : novels)
        {
            final String novelTitle;

            novelTitle = novel.getTitle().toLowerCase();

            if(novelTitle.contains(wordLowerCase))
            {
                counter++;
            }
        }

        return counter;
    }

    /**
     * Returns a double value of the ratio of novels between the ranges passed as
     * parameters and the total number of novels.
     *
     * @param lowerBound int that indicates the lower limit of years
     * @param upperBound int that indicates the upper limit of years
     * @return double representing the percentage of novels between the lower and upper bounds
     */
    public double whichPercentWrittenBetween(final int lowerBound,
                                             final int upperBound)
    {
        int counter;

        counter = 0;

        for(Novel novel : novels)
        {
            final int novelYearPublished;

            novelYearPublished = novel.getYearPublished();

            if(novelYearPublished <= upperBound && novelYearPublished >= lowerBound)
            {
                ++counter;
            }
        }

        return ((double)counter / (double) novels.size()) * PERCENTAGE_CONVERTOR;
    }

    /**
     * Returns the oldest book from the book list.
     * @return Book object that is oldest
     */
    public Novel getOldestBook()
    {
        Novel oldestBook;

        oldestBook = novels.getFirst();

        for (Novel novel : novels)
        {
            final int novelYearPublished;
            final int oldestBookYearPublished;

            novelYearPublished      = novel.getYearPublished();
            oldestBookYearPublished = oldestBook.getYearPublished();

            if (novelYearPublished < oldestBookYearPublished)
            {
                oldestBook = novel;
            }
        }

        return oldestBook;
    }

    /**
     * Returns a list of novels with titles of the specified length.
     *
     * @param length the desired title length
     * @return a list of novels with titles of the given length
     */
    public List<Novel> getBooksThisLength(final int length)
    {
        final List<Novel> novelsWithLength;

        novelsWithLength = new ArrayList<>();

        for(Novel novel : novels)
        {
            final int novelTitleLength;

            novelTitleLength = novel.getTitle().length();

            if(novelTitleLength == length)
            {
                novelsWithLength.add(novel);
            }
        }

        return novelsWithLength;
    }

    /**
     * Main method to test the functionality of the {@code BookStore} class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        BookStore         store;
        final Novel       oldest;
        final List<Novel> fifteenCharTitles;

        store = new BookStore("Books and Books and Books");
        System.out.println("Welcome to " + store.getStoreName());

        System.out.println("Print all of the book titles in UPPERCASE");
        store.printAllTitles();

        System.out.println("\nBook Titles containing \"The\"");
        store.printBookTitle("the");

        System.out.println("\nAll Titles in Alphabetical Order");
        store.printTitlesInAlphaOrder();

        System.out.println("\nBooks from the 2000s");
        store.printGroupByDecade(2000);

        System.out.println("\nLongest Book Title");
        store.printLongest();

        System.out.println("\nReturns if there is a book written in 1950?");
        System.out.println(store.isThereABookWrittenIn(1950));

        System.out.println("\nHow many books contain heart?");
        System.out.println(store.howManyBooksContain("heart"));

        System.out.println("\nPercentage of books written between 1940 and 1950:");
        System.out.println(store.whichPercentWrittenBetween(1940, 1950) + "%");

        System.out.println("\nOldest Book Title");

        oldest = store.getOldestBook();
        System.out.println(oldest.getTitle() + " by " + oldest.getAuthor() + ", " +
                oldest.getYearPublished());

        System.out.println("\nNovels with 15 characters");
        fifteenCharTitles = store.getBooksThisLength(15);
        fifteenCharTitles.forEach(novels -> System.out.println(novels.getTitle()));


        System.out.println("\nIterator and HashMap.\nPrint All Titles");
        if(store.keyList != null) {
            final Iterator<String> it;

            it = store.keyList.iterator();

            while (it.hasNext())
            {
                final String key;
                final String valueTitle;
                final Novel  value;

                key = it.next();
                value = store.novelsMap.get(key);
                valueTitle = value.getTitle();

                System.out.println(valueTitle);
            }
        }

        System.out.println("\nAll titles containing \"The\" filtered out:");
        if(store.keyList != null)
        {
            final Iterator<String> it;

            it = store.keyList.iterator();

            while(it.hasNext())
            {
                final String key;

                key = it.next();
                if(key.toLowerCase().contains("the"))
                {
                    it.remove();
                    store.novelsMap.remove(key);
                }
            }

            for(String key : store.keyList)
            {
                final Novel value;

                value = store.novelsMap.get(key);
                System.out.println(value);
            }
        }

    }
}