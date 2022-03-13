package domain.player;

import static java.util.Collections.unmodifiableList;

import domain.card.Card;
import domain.card.Cards;
import domain.util.ScoreUtil;
import java.util.List;

public abstract class Player {
    private static final int BUST_CRITERIA = 21;
    private static final int BLACK_JACK = 21;

    private final String name;
    private final Cards cards;

    protected Player(String name) {
        this.name = name;
        this.cards = new Cards();
    }

    public String getName() {
        return this.name;
    }

    public void addCard(Card card) {
        cards.addCard(card);
    }

    public int getPlayResult() {
        return ScoreUtil.getScore(cards.getCards());
    }

    public boolean isBust() {
        return getPlayResult() > BUST_CRITERIA;
    }

    public boolean isBlackJack() {
        return getPlayResult() == BLACK_JACK;
    }

    public List<Card> getCards() {
        return unmodifiableList(cards.getCards());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("name='").append(name).append('\'');
        sb.append(", cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }
}
