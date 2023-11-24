package umc.coffeein.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HashTagEnum {

    SANMI("산미있는"),
    GOSO("고소한"),
    KKALKEUM("깔끔한"),
    DECAFEINE("디카페인"),
    VARIETY("커피원두"),
    SIGNATURE("시그니처"),
    FRESH_JUICE("생과일쥬스"),
    TEA("차"),
    SMOOTHIE("스무디"),
    ADE("에이드"),

    CAKE("케이크"),
    BREAD("빵"),
    COOKIE("쿠키"),
    ICE_CREAM("아이스크림"),

    EMOTIONAL("감성카페"),
    GOOD_ATMOSPHERE("분위기가 좋은"),
    QUIET("조용한"),
    CAFE_STUDY("카공"),
    NATURE("자연"),
    CITY("도시"),
    COZY("아늑한"),

    COST_EFFECTIVE("가성비"),
    EXPENSIVE("비싼"),
    ANIMAL("동물"),
    VEGAN("비건"),
    DOG_CAFE("애견카페"),
    KIDS_CAFE("키즈카페");

    private String tag;
}
