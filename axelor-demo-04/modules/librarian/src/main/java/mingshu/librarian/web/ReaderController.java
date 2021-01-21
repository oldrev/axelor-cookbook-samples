package mingshu.librarian.web;

// 导入系统库
import com.axelor.auth.db.User;
import com.axelor.db.JpaSupport;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

// 导入模块库
import mingshu.librarian.db.*;
import mingshu.librarian.db.repo.ReaderRepository;
import mingshu.librarian.service.*;

public class ReaderController extends JpaSupport {

    @Inject private ReaderRepository _readers;
    @Inject private ReaderService _readerService;

    /**
     * 按下“设置用户”后端执行的操作
     */
    public void onAssignUser(ActionRequest request, ActionResponse response) {

        // 用 request 里 JSON 解析出来的 Map 字段名=>值 来填充对象 reader 里的对应属性
        Reader reader = request.getContext().asType(Reader.class);

        // 用 id 字段去数据库里查询 reader，返回 Hibernate 跟踪的实体类对象，
        // 后续操作一般是使用 Hibernate 跟踪的对象
        reader = _readers.find(reader.getId());

        if (reader.getUser() == null) {
            User newUser  =_readerService.assignNewUser(reader);
        }

        response.setFlash("命叔说：读者配套的登录用户设置好了"); // 前端弹出消息
        response.setReload(true); // 要求前端重新加载数据
    }


}
