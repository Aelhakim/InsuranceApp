/**
 * 
 */
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// for xml writting
@XmlRootElement(name = "members")
@XmlAccessorType (XmlAccessType.FIELD)
public class Members implements Serializable{
    @XmlElement(name = "member")
    List<Member> members = null;
    
    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}