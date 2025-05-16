import java.util.ArrayList;
import java.util.List;

public class StudentSorter {
    public static void mergeByAge (List<Student> students, int left, int mid, int right)
    {
        // Find the sizes of two sub-lists to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp list
        List<Student> L = new ArrayList<>();
        List<Student> R = new ArrayList<>();

        // Copy data to temp lists
        for (int i = 0; i < n1; i++)
        {
            L.add(students.get(left + i));
        }

        for (int j = 0; j < n2; j++)
        {
            R.add(students.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2){
            if (L.get(i).getAge() <= R.get(j).getAge()){
                students.set(k, L.get(i));
                i++;
            }
            else{
                students.set(k, R.get(j));
                j++;
            }
            k++;
        }

        while (i < n1){
            students.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2){
            students.set(k, R.get(j));
            j++;
            k++;
        }
    }

    public static void sortByAge(List<Student> students, int left, int right)
    {
        if (left < right){
            int mid = left + (right - left) / 2;

            sortByAge(students, left, mid);
            sortByAge(students, mid + 1, right);

            mergeByAge(students, left, mid, right);
        }
    }

    public static void mergeByID(List<Student> students, int left, int mid, int right)
    {
        // Find the sizes of two sub-lists to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp list
        List<Student> L = new ArrayList<>();
        List<Student> R = new ArrayList<>();

        // Copy data to temp lists
        for (int i = 0; i < n1; i++)
        {
            L.add(students.get(left + i));
        }

        for (int j = 0; j < n2; j++)
        {
            R.add(students.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2){
            if (L.get(i).getStudentId() <= R.get(j).getStudentId()){
                students.set(k, L.get(i));
                i++;
            }
            else{
                students.set(k, R.get(j));
                j++;
            }
            k++;
        }

        while (i < n1){
            students.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2){
            students.set(k, R.get(j));
            j++;
            k++;
        }
    }
    public static void sortByID(List<Student> students, int left, int right)
    {
        if (left < right){
            int mid = left + (right - left) / 2;

            sortByID(students, left, mid);
            sortByID(students, mid + 1, right);

            mergeByID(students, left, mid, right);
        }
    }
}
