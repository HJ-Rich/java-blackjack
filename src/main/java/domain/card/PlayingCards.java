package domain.card;

import java.util.ArrayList;
import java.util.List;

public class PlayingCards {
    private static final int MAXIMUM_VALID_SCORE = 21;
    private static final int ALTERNATIVE_ACE_GAP = 10;
    private static final int CARD_QUANTITY_FOR_BLACKJACK = 2;

    private final List<PlayingCard> playingCards;

    public PlayingCards() {
        this(new ArrayList<>());
    }

    public PlayingCards(List<PlayingCard> playingCards) {
        this.playingCards = new ArrayList<>(playingCards);
    }

    public void addCard(PlayingCard playingCard) {
        playingCards.add(playingCard);
    }

    public boolean isBust() {
        return calculateScore() > MAXIMUM_VALID_SCORE;
    }

    public boolean isBlackJack() {
        return getScore() == MAXIMUM_VALID_SCORE && playingCards.size() == CARD_QUANTITY_FOR_BLACKJACK;
    }

    public int getScore() {
        return calculateScore();
    }

    private int calculateScore() {
        if (containsAce()) {
            return calculateScoreWithAce();
        }

        return calculateScoreWithoutAce();
    }

    private boolean containsAce() {
        return playingCards.stream()
                .anyMatch(PlayingCard::isAce);
    }

    private int calculateScoreWithAce() {
        int minimumScore = calculateScoreWithoutAce();

        if (minimumScore + ALTERNATIVE_ACE_GAP <= MAXIMUM_VALID_SCORE) {
            return minimumScore + ALTERNATIVE_ACE_GAP;
        }

        return minimumScore;
    }

    private int calculateScoreWithoutAce() {
        return playingCards.stream()
                .mapToInt(PlayingCard::getScore)
                .sum();
    }

    public List<PlayingCard> getCards() {
        return new ArrayList<>(playingCards);
    }
}
