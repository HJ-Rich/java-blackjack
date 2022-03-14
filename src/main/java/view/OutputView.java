package view;

import static domain.MatchResult.DRAW;
import static domain.MatchResult.LOSE;
import static domain.MatchResult.WIN;

import domain.BlackJackResult;
import domain.MatchResult;
import domain.card.Card;
import domain.player.Dealer;
import dto.OpenCardsDto;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final long ZERO_FOR_DEFAULT = 0L;
    private static final String INFO_FOR_INITIAL_SPREAD = "%s와 %s에게 2장을 나누었습니다.%n";
    private static final String INFO_FOR_DEALER_ADD_CARD = "%s는 16이하라 한장의 카드를 더 받았습니다.%n";
    private static final String INFO_PLAYER_CARD_AND_SCORE = "%s카드: %s - 결과: %d%n";
    private static final String INFO_CARD_STATUS_AFTER_INITIAL_SPREAD = "%s: %s%n";
    private static final String COLON_FOR_JOINING_NAME_AND_CARD = ": ";
    private static final String RESULT_TITLE = "## 최종 승패";
    private static final String DEALER_RESULT_PRINT_TEMPLATE = "딜러: %d승 %d무 %d패%n";
    private static final String STRING_FOR_WIN = "승";
    private static final String STRING_FOR_LOSE = "패";
    private static final String STRING_FOR_DRAW = "무";
    private static final String CARD_NAME_JOIN_CHARACTER = ", ";
    private static final String GAMBLER_NAME_DELIMITER = ", ";


    private OutputView() {
    }

    public static void printSpreadAnnouncement(String dealerName, List<String> gamblerNames) {
        System.out.println();
        System.out.printf(INFO_FOR_INITIAL_SPREAD, dealerName, String.join(GAMBLER_NAME_DELIMITER, gamblerNames));
    }

    public static void printInitialOpenCards(List<OpenCardsDto> openCardsDtos) {
        openCardsDtos.forEach(
                openCardsDto -> System.out.printf(
                        INFO_CARD_STATUS_AFTER_INITIAL_SPREAD,
                        openCardsDto.getName(), getJoinedCardNames(openCardsDto.getInitialOpenCards())
                ));
    }

    private static String getJoinedCardNames(List<Card> cards) {
        return cards.stream()
                .map(Card::getCardName)
                .collect(Collectors.joining(CARD_NAME_JOIN_CHARACTER));
    }

    public static void printLineSeparator() {
        System.out.println();
    }

    public static void printCards(OpenCardsDto playerDto) {
        System.out.println(
                playerDto.getName() + COLON_FOR_JOINING_NAME_AND_CARD + getJoinedCardNames(
                        playerDto.getInitialOpenCards()));
    }

    public static void printDealerAddCard(Dealer dealer) {
        System.out.printf(INFO_FOR_DEALER_ADD_CARD, dealer.getName());
    }

    public static void printCardAndScore(OpenCardsDto playerDto) {
        System.out.printf(INFO_PLAYER_CARD_AND_SCORE,
                playerDto.getName(),
                getJoinedCardNames(playerDto.getInitialOpenCards()),
                playerDto.getInitialOpenCards());
    }

    public static void printResult(BlackJackResult blackJackResult) {
        System.out.println(System.lineSeparator() + RESULT_TITLE);
        printDealerResult(blackJackResult);
        blackJackResult.getGamblerResult()
                .forEach(OutputView::printSingleGamblerResult);
    }

    private static void printDealerResult(BlackJackResult blackJackResult) {
        Map<MatchResult, Long> dealerResult = blackJackResult.getDealerResult();
        System.out.printf(
                DEALER_RESULT_PRINT_TEMPLATE,
                dealerResult.getOrDefault(WIN, ZERO_FOR_DEFAULT),
                dealerResult.getOrDefault(DRAW, ZERO_FOR_DEFAULT),
                dealerResult.getOrDefault(LOSE, ZERO_FOR_DEFAULT)
        );
    }

    public static void printSingleGamblerResult(String name, MatchResult matchResult) {
        System.out.println(name + COLON_FOR_JOINING_NAME_AND_CARD + getStringByMatchResult(matchResult));
    }

    private static String getStringByMatchResult(MatchResult matchResult) {
        if (matchResult == WIN) {
            return STRING_FOR_WIN;
        }

        if (matchResult == LOSE) {
            return STRING_FOR_LOSE;
        }

        return STRING_FOR_DRAW;
    }
}
