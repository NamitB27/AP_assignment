In this code there are 4 classes, Book class,Member class,Library class and the Main public class.

the book class contains attributes like title , author, total_copies being used.
this class also contains 4 hashmaps and 5 methods like view_book1,2 and 3, add_mem2_B and remove_B_mem2
view books display all the books in the library
add_mem adds books in the library portal
remove_mem removes books from the library portal
the hashmaps title_id stores book title and book id as key and value
title_copies stores book title and copies as key and value
title_author stores book title and author name as key and value
bookID_title stores book id and book title as key and value

the member class contains 1 hashmap bookID_issued with attributes book id and issued book
it has methods like my books, issued_book, pay_fine and return_book
issued books issues book for the member from the library and return_book returns that book after which if the member returns the book after 10 days he will have to pay fine in pay_fine2.

the library class contains 3 attributes and 2 hashmaps
attributes are name age and phone number and hashmaps and age_name and number name which stores age name and phone number
add_mem1 and remove_mem1 registers and removes members from the library portal
the Main class contains start time and end time which are used to calculate the due time for the fines
the method lib has the library UI which asks the librarian what they can do
the method mem has the library UI which asks the members what they can do
the method start is the first method of the code which starts the library portal

the whole code is coded in such a way that all things are stored in a single execution

