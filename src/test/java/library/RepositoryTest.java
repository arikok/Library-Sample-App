package library;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ea.library.model.db.DBBook;
import com.ea.library.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})                                    
public class RepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void testInsert() {

		DBBook book = new DBBook();
		book.setAuthor("DenemeYazari");
		book.setBookName("DenemeKitap");
		bookRepository.save(book);

	}

	@Test
	public void testUpdate() {

		DBBook book = new DBBook();
		book.setAuthor("DenemeYazariUpdate");
		book.setBookName("DenemeKitapUpdate");
		bookRepository.save(book);
		book = bookRepository.findAll().get(0);
		String id = book.getId();
		book.setAuthor("DegisenAuthor");
		book.setBookName("DegisenBookName");
		bookRepository.save(book);

		if (bookRepository.findOne(id).getAuthor().equals("DegisenAuthor")) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

}
