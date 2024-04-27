package by.school.app.models.users;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;

/**
 * Parent.
 *
 * @author Victor Bakhanovich <victor.bahanovich@gmail.com>
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "children")
public class Parent extends User {
    @ManyToMany(targetEntity = Student.class, fetch = FetchType.LAZY, mappedBy = "parents")
    private Set<Student> children;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parent parent)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(children, parent.children);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(children);
        return result;
    }
}
