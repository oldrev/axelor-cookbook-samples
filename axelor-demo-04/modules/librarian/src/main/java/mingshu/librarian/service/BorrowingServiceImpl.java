package mingshu.librarian.service;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import mingshu.librarian.db.Borrowing;
import mingshu.librarian.db.BorrowingStatus;
import mingshu.librarian.db.repo.BorrowingRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BorrowingServiceImpl implements BorrowingService {

    @Inject private BorrowingRepository _borrowings;

    public String getCode() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
    }

    @Override
    @Transactional
    public Borrowing confirm(Long id) {
        Borrowing borrowing = _borrowings.find(id);
        borrowing.setReturnTime(borrowing.getBorrowTime().plusDays(borrowing.getDays()));
        borrowing.setStatus(BorrowingStatus.WAIT);
        _borrowings.save(borrowing);
        return borrowing;
    }

    @Override
    @Transactional
    public Borrowing back(Long id) {
        Borrowing borrowing = _borrowings.find(id);
        borrowing.setBackTime(LocalDateTime.now());
        borrowing.setStatus(BorrowingStatus.DONE);
        _borrowings.save(borrowing);
        return borrowing;
    }


}
