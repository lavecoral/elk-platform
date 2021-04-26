package me.lavecoral.elk.auth.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author lave
 * @date 2021/4/26 22:05
 */
public class PermissionDto implements Serializable {

    private static final long serialVersionUID = -304715622966805770L;

    private Long id;
    private String name;
    private String uri;

    public PermissionDto() {
    }

    public PermissionDto(Long id, String name, String uri) {
        this.id = id;
        this.name = name;
        this.uri = uri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "PermissionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PermissionDto that = (PermissionDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(uri, that.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, uri);
    }
}
