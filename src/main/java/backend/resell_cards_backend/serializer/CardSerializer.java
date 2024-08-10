package backend.resell_cards_backend.serializer;

import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import backend.resell_cards_backend.domains.MTGCard;
import backend.resell_cards_backend.enums.MTGCardType;

public class CardSerializer extends StdSerializer<MTGCard> {

  public CardSerializer() {
    this(null);
  }

  public CardSerializer(Class<MTGCard> t) {
    super(t);
  }

  @Override
  public void serialize(MTGCard card, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {

    List<String> cardTypesToString = new ArrayList<>();

    for (MTGCardType type : card.getMtgCardType()) {
      String typeString = type.name();
      StringBuilder stringBuilder = new StringBuilder();

      stringBuilder.append(typeString.substring(0, 1));
      stringBuilder.append(typeString.substring(1).toLowerCase());

      cardTypesToString.add(stringBuilder.toString());
    }

    jgen.writeStartObject();
    jgen.writeStringField("mtgCardName", card.getMtgCardName());
    jgen.writeFieldName("mtgCardType");
    jgen.writeObject(cardTypesToString);
    jgen.writeStringField("mtgCardEdition", card.getMtgCardEdition());
    jgen.writeNumberField("mtgCardValue", card.getMtgCardValue());
    jgen.writeEndObject();
  }

}
