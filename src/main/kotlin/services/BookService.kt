package services

import data.Book
import data.BookEntity
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class BookService {

    fun getAllBooks(): Iterable<Book> = transaction {
        BookEntity.all().map(BookEntity::toBook)
    }


    fun getAbook(bookId: Int): Book = transaction {
        BookEntity.get(bookId).toBook()
    }

    fun addBook(book: Book) = transaction {
        BookEntity.new {
            this.title = book.title
            this.author = book.author
        }
    }

    fun deleteBook(bookId: Int) = transaction {
        BookEntity[bookId].delete()
    }
}
