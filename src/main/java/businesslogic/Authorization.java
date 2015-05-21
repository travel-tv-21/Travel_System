package businesslogic;

import Model.Entities.UserEntity;
import Model.Entities.UserTypeEntity;
import Model.dao.interfaces.GenericDao;
import Model.dto.SignInForm;

import javax.servlet.http.Cookie;
import java.util.List;

/**
 * Created by yarik on 20.05.2015.
 */
public class Authorization {

    private GenericDao genericDao;

    public Authorization(GenericDao genericDao) {
        this.genericDao = genericDao;
    }


    public UserTypeEntity check(SignInForm signInForm, Cookie userIdCookie) {
        List<UserEntity> users = genericDao.findAll(UserEntity.class);
        UserEntity ourUser = null;
        for (UserEntity u : users) {
            //System.out.println(u.getLogin() + " " + signInForm.getLogin()+",");
            if (u.getLogin().equals(signInForm.getLogin())
                    && u.getPassword().equals(signInForm.getPassword())) {
                ourUser = u;
                break;
            }
        }
        if (ourUser == null) {
            return null;
        }

        UserTypeEntity userType = (UserTypeEntity) genericDao.findById(UserTypeEntity.class,
                ourUser.getUserTypeId());
        if (userIdCookie != null) {
            userIdCookie.setValue(String.valueOf(ourUser.getId()));
        }
        return userType;
    }
}


