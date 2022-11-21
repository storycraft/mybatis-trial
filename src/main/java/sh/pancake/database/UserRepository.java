package sh.pancake.database;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserRepository {

    /**
     * 유저 데이터를 삽입합니다
     * 
     * @param user
     * @return 변경된 row의 수
     */
    int insert(User user);

    /**
     * id를 사용해 유저 데이터를 가져옵니다
     * 
     * @param id
     * @return 유저 데이터. 없으면 null 반환
     */
    User getUserById(long id);

    /**
     * user 테이블에서 해당 id를 가진 record를 제거합니다
     * 
     * @param id
     * @return 변경된 row의 수
     */
    int removeUser(long id);
    
    /**
     * user 테이블에서 해당 id를 가진 record의 profile_name을 업데이트합니다
     *
     * @param id
     * @param profileName
     * @return 변경된 row의 수
     */

    int updateProfileName(@Param("id") long id, @Param("profileName") String profileName);

    /**
     * 모든 유저의 정보를 가져옵니다
     * 
     * @return 유저 id와 User객체 쌍 리스트 
     */
    List<User> getAllUsers();
}
