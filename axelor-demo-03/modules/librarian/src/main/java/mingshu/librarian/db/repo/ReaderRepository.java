package mingshu.librarian.db.repo;

import com.axelor.auth.db.User;
import com.axelor.auth.db.repo.UserRepository;
import com.axelor.inject.Beans;
import mingshu.librarian.db.Reader;

import javax.inject.Inject;

public class ReaderRepository extends AbstractReaderRepository {

    @Inject
    private UserRepository _users;

    /**
     * 覆盖父类方法，删除读者信息时删除配套的用户
     * @param reader
     */
    @Override
    public void remove(Reader reader) {

        if (reader.getUser() != null) {
            User user = _users.find(reader.getUser().getId());
            if (user != null) {
                user.setReader(null);
                _users.save(user);
            }
        }

        super.remove(reader);
    }
}
