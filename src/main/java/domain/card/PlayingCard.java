package domain.card;

import java.util.Objects;

public class PlayingCard {
    private final Suit suit;
    private final Denomination denomination;

    private PlayingCard(Suit suit, Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public static PlayingCard of(Suit suit, Denomination denomination) {
        return new PlayingCard(suit, denomination);
    }

    public boolean isAce() {
        return denomination.isAce();
    }

    public Suit getSuit() {
        return suit;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public int getScore() {
        return denomination.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayingCard that = (PlayingCard) o;
        return suit == that.suit && denomination == that.denomination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, denomination);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("suit=").append(suit);
        sb.append(", denomination=").append(denomination);
        sb.append('}');
        return sb.toString();
    }
}
