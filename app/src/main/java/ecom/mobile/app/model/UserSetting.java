package ecom.mobile.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int enableFingerPrint;
    private int enableNotification;
    private int enableLocationService;

    @OneToOne(
            mappedBy = "setting"
    )
    @JsonBackReference
    private User user;

}
