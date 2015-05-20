package businesslogic;

import Model.Entities.UserEntity;
import Model.Entities.UserTypeEntity;
import Model.dao.interfaces.GenericDao;
import Model.dto.SignInForm;

import java.util.List;

/**
 * Created by yarik on 20.05.2015.
 */
public class Authorization {

    private GenericDao genericDao;

    public Authorization(GenericDao genericDao) {
        this.genericDao = genericDao;
    }


    public UserTypeEntity check(SignInForm signInForm) {
        List<UserEntity> users = genericDao.findAll(UserEntity.class);
        UserEntity ourUser = null;
        for (UserEntity u : users) {
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

        return userType;
    }
}


