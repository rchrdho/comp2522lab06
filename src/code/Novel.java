import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Novel} class represents a novel with a title, author, and year of publication.
 * It also implements the {@link Comparable} interface to allow comparison between novels based on their titles.
 *
 * @author Richard Ho
 * @author Bryson Lindy
 * @author Phyo Thu Kha
 *
 * @version 1.0
 */
public class Novel extends Literature implements Comparable<Novel>
{
    private static final String[] TITLES = {
            "The Adventures of Augie March",
            "All the King's Men",
            "American Pastoral",
            "An American Tragedy",
            "Animal Farm",
            "Appointment in Samarra",
            "Are You There God? It's Me Margaret.",
            "The Assistant",
            "At Swim-Two-Birds",
            "Atonement",
            "Beloved",
            "The Berlin Stories",
            "The Big Sleep",
            "The Blind Assassin",
            "Blood Meridian",
            "Brideshead Revisited",
            "The Bridge of San Luis Rey",
            "Call It Sleep",
            "Catch-22",
            "The Catcher in the Rye",
            "A Clockwork Orange",
            "The Confessions of Nat Turner",
            "The Corrections",
            "The Crying of Lot 49",
            "A Dance to the Music of Time",
            "The Day of the Locust",
            "Death Comes for the Archbishop",
            "A Death in the Family",
            "The Death of the Heart",
            "Deliverance",
            "Dog Soldiers",
            "Falconer",
            "The French Lieutenant's Woman",
            "The Golden Notebook",
            "Go Tell It on the Mountain",
            "Gone with the Wind",
            "The Grapes of Wrath",
            "Gravity's Rainbow",
            "The Great Gatsby",
            "A Handful of Dust",
            "The Heart Is a Lonely Hunter",
            "The Heart of the Matter",
            "Herzog",
            "Housekeeping",
            "A House for Mr. Biswas",
            "I Claudius",
            "Infinite Jest",
            "Invisible Man",
            "Light in August",
            "The Lion The Witch and the Wardrobe",
            "Lolita",
            "Lord of the Flies",
            "The Lord of the Rings",
            "Loving",
            "Lucky Jim",
            "The Man Who Loved Children",
            "Midnight's Children",
            "Money",
            "The Moviegoer",
            "Mrs. Dalloway",
            "Naked Lunch",
            "Native Son",
            "Neuromancer",
            "Never Let Me Go",
            "1984",
            "On the Road",
            "One Flew Over the Cuckoo's Nest",
            "The Painted Bird",
            "Pale Fire",
            "A Passage to India",
            "Play It as It Lays",
            "Portnoy's Complaint",
            "Possession",
            "The Power and the Glory",
            "The Prime of Miss Jean Brodie",
            "Rabbit Run",
            "Ragtime",
            "The Recognitions",
            "Red Harvest",
            "Revolutionary Road",
            "The Sheltering Sky",
            "Slaughterhouse-Five",
            "Snow Crash",
            "The Sot-Weed Factor",
            "The Sound and the Fury",
            "The Sportswriter",
            "The Spy Who Came in from the Cold",
            "The Sun Also Rises",
            "Their Eyes Were Watching God",
            "Things Fall Apart",
            "To Kill a Mockingbird",
            "To the Lighthouse",
            "Tropic of Cancer",
            "Ubik",
            "Under the Net",
            "Under the Volcano",
            "Watchmen",
            "White Noise",
            "White Teeth",
            "Wide Sargasso Sea"
    };

    private static final String[] AUTHORS = {
            "Saul Bellow",
            "Robert Penn Warren",
            "Philip Roth",
            "Theodore Dreiser",
            "George Orwell",
            "John O'Hara",
            "Judy Blume",
            "Bernard Malamud",
            "Flann O'Brien",
            "Ian McEwan",
            "Toni Morrison",
            "Christopher Isherwood",
            "Raymond Chandler",
            "Margaret Atwood",
            "Cormac McCarthy",
            "Evelyn Waugh",
            "Thornton Wilder",
            "Henry Roth",
            "Joseph Heller",
            "J.D. Salinger",
            "Anthony Burgess",
            "William Styron",
            "Jonathan Franzen",
            "Thomas Pynchon",
            "Anthony Powell",
            "Nathanael West",
            "Willa Cather",
            "James Agee",
            "Elizabeth Bowen",
            "James Dickey",
            "Robert Stone",
            "John Cheever",
            "John Fowles",
            "Doris Lessing",
            "James Baldwin",
            "Margaret Mitchell",
            "John Steinbeck",
            "Thomas Pynchon",
            "F. Scott Fitzgerald",
            "Evelyn Waugh",
            "Carson McCullers",
            "Graham Greene",
            "Saul Bellow",
            "Marilynne Robinson",
            "V.S. Naipaul",
            "Robert Graves",
            "David Foster Wallace",
            "Ralph Ellison",
            "William Faulkner",
            "C.S. Lewis",
            "Vladimir Nabokov",
            "William Golding",
            "J.R.R. Tolkien",
            "Henry Green",
            "Kingsley Amis",
            "Christina Stead",
            "Salman Rushdie",
            "Martin Amis",
            "Walker Percy",
            "Virginia Woolf",
            "William Burroughs",
            "Richard Wright",
            "William Gibson",
            "Kazuo Ishiguro",
            "George Orwell",
            "Jack Kerouac",
            "Ken Kesey",
            "Jerzy Kosinski",
            "Vladimir Nabokov",
            "E.M. Forster",
            "Joan Didion",
            "Philip Roth",
            "A.S. Byatt",
            "Graham Greene",
            "Muriel Spark",
            "John Updike",
            "E.L. Doctorow",
            "William Gaddis",
            "Dashiell Hammett",
            "Richard Yates",
            "Paul Bowles",
            "Kurt Vonnegut",
            "Neal Stephenson",
            "John Barth",
            "William Faulkner",
            "Richard Ford",
            "John le Carré",
            "Ernest Hemingway",
            "Zora Neale Hurston",
            "Chinua Achebe",
            "Harper Lee",
            "Virginia Woolf",
            "Henry Miller",
            "Philip K. Dick",
            "Iris Murdoch",
            "Malcolm Lowry",
            "Alan Moore and Dave Gibbons",
            "Don DeLillo",
            "Zadie Smith",
            "Jean Rhys"
    };

    private static final int[] YEARS_PUBLISHED = {
            1953, 1946, 1997, 1925, 1946, 1934, 1970, 1957, 1938, 2002,
            1987, 1946, 1939, 2000, 1986, 1946, 1927, 1935, 1961, 1951,
            1963, 1967, 2001, 1966, 1951, 1939, 1927, 1958, 1958, 1970,
            1974, 1977, 1969, 1962, 1953, 1936, 1939, 1973, 1925, 1934,
            1940, 1948, 1964, 1981, 1962, 1934, 1996, 1952, 1932, 1950,
            1955, 1954, 1954, 1945, 1954, 1940, 1981, 1984, 1961, 1925,
            1959, 1940, 1984, 2005, 1948, 1957, 1962, 1965, 1962, 1924,
            1970, 1969, 1990, 1939, 1961, 1960, 1975, 1955, 1929, 1961,
            1949, 1969, 1992, 1960, 1929, 1986, 1964, 1926, 1937, 1959,
            1960, 1929, 1934, 1969, 1954, 1947, 1986, 1985, 2000, 1966
    };

    private final String title;
    private final String author;
    private final int    yearPublished;

    /**
     * Constructs a new {@code Novel} instance with the specified title, author, and year of publication.
     *
     * @param title         the title of the novel
     * @param author        the author of the novel
     * @param yearPublished the year the novel was published
     */
    public Novel(final String  title,
                 final String  author,
                 final int     yearPublished)
    {
        this.title         = title;
        this.author        = author;
        this.yearPublished = yearPublished;
    }

    /**
     * Creates a list of {@code Novel} objects using the predefined arrays of titles, authors, and publication years.
     *
     * @return a list of {@code Novel} objects
     */
    public static List<Novel> createNovelList()
    {
        final List<Novel> novels;
        novels = new ArrayList<>();

        for(int i = 0; i < TITLES.length; ++i)
        {
            novels.add(new Novel(TITLES[i], AUTHORS[i], YEARS_PUBLISHED[i]));
        }

        return novels;
    }

    /**
     * Gets the title of the novel.
     *
     * @return the title of the novel
     */
    @Override
    public String getTitle()
    {
        return title;
    }

    /**
     * Gets the author of the novel.
     *
     * @return the author of the novel
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Gets the year the novel was published.
     *
     * @return the year the novel was published
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Compares this novel with the specified novel for order based on the title, ignoring case considerations.
     *
     * @param that the novel to be compared
     * @return     a negative integer, zero, or a positive integer as this novel's title is lexicographically less
     * than, equal to, or greater than the specified novel's title
     */
    @Override
    public int compareTo(final Novel that)
    {
        return this.title.compareToIgnoreCase(that.getTitle());
    }

    /**
     * Returns a string representation of this object, which includes the title,
     * author, and year of publication in a specific format.
     * <p>
     * The format of the returned string is as follows:
     * <blockquote>
     * "<i>Title</i>" written by <i>Author</i> in <i>YearPublished</i>
     * </blockquote>
     *
     * @return a formatted string representing the book or document,
     *         including the title, author, and year of publication.
     */
    @Override
    public String toString()
    {
        final StringBuilder bob;

        bob = new StringBuilder();

        bob.append("\"").append(getTitle()).append("\" written by ").append(getAuthor());
        bob.append(" in ").append(getYearPublished());

        return bob.toString();
    }

}
