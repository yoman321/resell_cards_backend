package backend.resell_cards_backend.serializer;

import java.io.IOException;

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

    jgen.writeStartObject();
    jgen.writeStringField("mtgCardName", card.getMtgCardName());

    jgen.writeStartArray("mtgCardType");
    for (MTGCardType type : card.getMtgCardType()) {
      jgen.writeString(type.name().toLowerCase());
    }
    jgen.writeEndArray();

    jgen.writeStringField("mtgCardEdition", card.getMtgCardEdition());
    jgen.writeNumberField("mtgCardValue", card.getMtgCardValue());
    jgen.close();
  }
}
