package mingshu.librarian.service;

import com.axelor.auth.db.*;
import mingshu.librarian.db.*;

public interface ReaderService {

    User assignNewUser(Reader reader);
}
