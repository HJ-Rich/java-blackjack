package domain.card;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class PlayingCards {
    private final List<PlayingCard> playingCards = new ArrayList<>();

    public void addCard(PlayingCard playingCard) {
        playingCards.add(playingCard);
    }

    public List<PlayingCard> getPlayingCards() {
        return unmodifiableList(playingCards);
    }
}
