package domain.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayingCardDeckTest {
    @Test
    @DisplayName("카드덱 생성 테스트")
    void createCardDeck() {
        assertThatCode(CardDeck::newInstance)
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("카드덱에서 카드를 한 장씩 꺼낼 수 있다")
    void drawCardFromCardDeck() {
        // given
        CardDeck cardDeck = CardDeck.newInstance();

        // when
        PlayingCard clubsAce = cardDeck.drawCard();
        PlayingCard clubsTwo = cardDeck.drawCard();

        // then
        assertAll(
                () -> assertThat(clubsAce).isEqualTo(PlayingCard.of(Suit.CLUBS, Denomination.ACE)),
                () -> assertThat(clubsTwo).isEqualTo(PlayingCard.of(Suit.CLUBS, Denomination.TWO))
        );
    }

    @Test
    @DisplayName("카드를 한 장이라도 꺼냈었던 카드덱은 다시 섞을 수 없다")
    void usedCardDeckShouldNotBeShuffled() {
        // given
        CardDeck cardDeck = CardDeck.newInstance();

        // when
        PlayingCard playingCard = cardDeck.drawCard();

        // then
        assertThatThrownBy(cardDeck::shuffle)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("사용중인 카드는 다시 섞을 수 없습니다.");
    }
}
