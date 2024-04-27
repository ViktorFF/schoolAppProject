package by.school.app.models.users;

import by.school.app.enums.SchoolStaffType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;

/**
 * SchoolStaff.
 *
 * @author Victor Bakhanovich &lt;victor.bahanovich@gmail.com&gt;
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "schoolStaffTypes")
public class SchoolStaff extends User {
    private Set<SchoolStaffType> schoolStaffTypes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SchoolStaff that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(schoolStaffTypes, that.schoolStaffTypes);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(schoolStaffTypes);
        return result;
    }
}
