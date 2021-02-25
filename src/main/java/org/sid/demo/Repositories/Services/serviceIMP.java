package org.sid.demo.Repositories.Services;

import net.bytebuddy.utility.RandomString;
import org.sid.demo.Repositories.BookRepository;
import org.sid.demo.Repositories.ReservationRepository;
import org.sid.demo.Repositories.StudentRepository;
import org.sid.demo.entities.Book;
import org.sid.demo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class serviceIMP implements service {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ReservationRepository reservationRepository ;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void initStudent() {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            Student student = new Student(null, RandomString.make(10), RandomString.make(10), RandomString.make(5), RandomString.make(5), RandomString.make(15));
            studentRepository.save(student);
        }

    }

    @Override
    public void initBook() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            Book book = new Book(null, RandomString.make(10), RandomString.make(12), LocalDate.now(), random.nextBoolean());
            bookRepository.save(book);
        }
    }


    @Override
    public void initReservation() {
        bookRepository.findAll().forEach( book -> {
        });
    }

    @Override
    public void initAffectation() {

    }
}
