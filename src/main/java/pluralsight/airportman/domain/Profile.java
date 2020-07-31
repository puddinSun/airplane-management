package pluralsight.airportman.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Profile {

  @Id
  private String id;

  private String name;

  @TextIndexed
  private String title;

  @TextIndexed
  private String aboutMe;

}
