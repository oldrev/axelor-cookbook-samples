package mingshu.librarian.service;

import com.axelor.meta.CallMethod;
import mingshu.librarian.db.Borrowing;

public interface BorrowingService {

    @CallMethod
    String getCode();

    Borrowing confirm(Long id);

    Borrowing back(Long id);

}
