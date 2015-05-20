package businesslogic;

import Model.Entities.UserEntity;
import Model.Entities.UserInfoEntity;
import Model.dao.interfaces.GenericDao;
import Model.dto.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yarik on 20.05.2015.
 */
public class SignUp {
    public static int USER_TYPE_ID = 1;

    @Autowired
    private GenericDao genericDao;


    public SignUp(){}

    public boolean addUser(SignUpForm form) {
        UserEntity userEntity = new UserEntity();
        UserInfoEntity userInfo = new UserInfoEntity();


        userInfo.setEmail(form.getEmail());
        userInfo.setName(form.getName());
        userInfo.setPhone(form.getPhone());
        userInfo.setDeleted((byte) 0);
        userInfo.setReviews(0);
        genericDao.create(userInfo);


        userEntity.setLogin(form.getLogin());
        userEntity.setPassword(form.getPassword());
        userEntity.setUserTypeId(USER_TYPE_ID);
        userEntity.setUserInfoId(userInfo.getId());
        userEntity.setDeleted((byte) 0);
        genericDao.create(userEntity);
        return true;
    }
}
