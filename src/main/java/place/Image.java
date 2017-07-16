package place;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.SQLException;

@Entity
@Table
@Getter @Setter
class Image {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private Blob data;

    protected Image() {
    }

    byte[] getImageAsBytes() {
        try {
            return data.getBytes(1, (int) data.length());
        } catch (SQLException e) {
            throw new ImageBlobSQLException(e);
        }
    }

    private class ImageBlobSQLException extends RuntimeException {
        ImageBlobSQLException(Throwable throwable) {
            super(throwable);
        }
    }

}
