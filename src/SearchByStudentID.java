import java.util.HashMap;
import java.util.List;

public class SearchByStudentID {

    public static Student addStudentByID (List<Student> listStudent, int id)
    {

        HashMap<Long, Student> dataBase = new HashMap<>();

        for (Student student : listStudent)
        {
            if (!dataBase.containsKey(student.getStudentId()))
            {
                dataBase.put(student.getStudentId(), student);
            }
        }
        return dataBase.get((long)id);
    }
}
