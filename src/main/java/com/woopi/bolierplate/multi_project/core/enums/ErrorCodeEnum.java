package com.woopi.bolierplate.multi_project.core.enums;

import lombok.Getter;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.Collections.unmodifiableMap;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public enum ErrorCodeEnum {
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "A server error has occurred.", 500),
    NOT_FOUND("NOT_FOUND", "The requested resource could not be found.", 404),
    VALIDATION_CHECK("VALIDATION_CHECK", "A validation error has occurred.", 400),
    ALREADY_EXIST("ALREADY_EXIST", "This resource already exists.", 401),
    UNAUTHORIZED_PERMISSION("UNAUTHORIZED_PERMISSION", "Unauthorized permission.", 403),
    BLOCK_ID("BLOCK_ID", "사용중지된 아이디입니다.\n관리자에게 문의 바랍니다.", 401),
    BLOCK_PASSWORD("BLOCK_PASSWORD", "비밀번호 오류 횟수 초과. 관리자에게 문의 바랍니다.", 401),
    INVALID_PASSWORD("INVALID_PASSWORD", "비밀번호가 일치하지 않습니다.", 401),
    MISSING_GOLF_CLUB_HEADER("MISSING_GOLF_CLUB_HEADER", "골프장 정보가 없습니다.", 403),
    MISMATCH_GOLF_CLUB_CODE("MISMATCH_GOLF_CLUB_CODE", "해당 골프장 회원이 아닙니다.", 403),
    INVALID_SERVICE("INVALID_SERVICE", "Invalid webapp service. Please try again.", 403),
    SESSION_EXPIRED("SESSION_EXPIRED", "세션이 만로되었습니다. 다시 로그인해주세요.", 401),
    TABLE_IN_USE("TABLE_IN_USE", "현재 태이블 사용 중입니다.", 400),
    TEAMS_PAY_LOCK("TEAMS_PAY_LOCK", "정산 작업중입니다,", 400),
    SOLD_OUT_ITEMS("SOLD_OUT_ITEMS", "주문하시는 메뉴 중 품절 메뉴가 있습니다.", 400),
    STORE_NOT_FOR_TABLE_USE("STORE_NOT_FOR_TABLE_USE", "해당 매장은 테이블 사용 매장이 아닙니다.", 400),
    ALREADY_CHECKED_OUT("ALREADY_CHECKED_OUT", "해당 팀은 이미 체크아웃하셨습니다.", 400),
    INTERCEPTED_ID("INTERCEPTED_ID", "회원님은 홈페이지 사용이 제한된 상태입니다.\n홈페이지 사용을 원하시면 골프클럽으로 연락주시기 바랍니다.", 403),
    NO_REQUIRED_COMMON_CODE_SETTING_VALUES("NO_REQUIRED_COMMON_CODE_SETTING_VALUES", "공통코드 설정 값이 존재하지 않습니다.", 400),
    NO_REFRESH_TOKEN("NO_REFRESH_TOKEN", "No refresh token", 403),

    /* KIOSK */
    DUPLICATE_PHONE_NUMBER("DUPLICATE_PHONE_NUMBER", "회원 핸드폰번호가 중복되었습니다.", 400),
    PENALTY_VISIT("PENALTY_VISIT", "내장 불가 위약이 발생되었습니다.", 400),
    VISITORS_MEMBER_NOT_FOUND("VISITORS_MEMBER_NOT_FOUND", "방문자의 회원정보를 찾을 수 없습니다.", 400),
    REQUIRED_PROVIDE_AGREE("REQUIRED_PROVIDE_AGREE", "개인정보 수집 및 이용 동의가 필요합니다.", 400),
    FULL_VISITORS_OF_TEAM("FULL_VISITORS_OF_TEAM", "체크인 가능 인원수를 초과하였습니다.", 400),
    DUPLICATED_VISITOR("DUPLICATED_VISITOR", "중복된 회원이 존재합니다.", 400),
    INVALID_CHECKIN_DATE("INVALID_CHECKIN_DATE", "유효하지 않은 체크인 일자입니다.", 400),
    EMPTY_BUSINESS_DATE("EMPTY_BUSINESS_DATE", "영업일 정보가 존재하지 않습니다.", 400),
    FRONT_STORE_CLOSE("FRONT_STORE_CLOSE", "프론트 매장이 일마감 되어 작업하실 수 없습니다.", 400),
    NOT_LATEST_DATA("NOT_LATEST_DATA", "최신 데이터가 아니어서 작업하실 수 없습니다.", 400),
    EMPTY_AVAILABLE_LOCKER("EMPTY_AVAILABLE_LOCKER", "사용 가능한 락커가 없습니다.", 400),
    EMPTY_AVAILABLE_LOCKER_SECTOR("EMPTY_AVAILABLE_LOCKER_SECTOR", "사용 가능한 락커 구역이 없습니다.", 400),
    INVALID_SEARCH_DIVISION("INVALID_SEARCH_DIVISION", "유효하지 않은 검색 구분입니다.", 400),
    PAYMENT_AMOUNT_NOT_MATCHED("PAYMENT_AMOUNT_NOT_MATCHED", "결제금액이 일치 하지 않습니다.", 400),
    EMPTY_RESERVATION("EMPTY_RESERVATION", "예약이 존재하지 않습니다.", 400),

    /* MOBILE SELF CHECK IN */
    UNAVAILABLE_CONFIG_SELF_CHECK_IN("UNAVAILABLE_CONFIG_SELF_CHECK_IN", "셀프 체크인 사용이 불가능합니다.", 400),
    EMPTY_RESERVATION_MEMBER_PHONE("EMPTY_RESERVATION_MEMBER_PHONE", "예약자 전화번호가 없습니다.", 400),
    NOT_SAME_RESERVATION_MEMBER_COMPANION_INFO("NOT_SAME_RESERVATION_MEMBER_COMPANION_INFO", "예약자, 동반자 정보가 일치하지 않습니다.", 400),
    NOT_CHECK_IN_TIME("NOT_CHECK_IN_TIME", "체크인 가능 시간이 아닙니다.", 400),
    NOT_CHECK_IN_DISTANCE("NOT_CHECK_IN_DISTANCE", "체크인 가능 거리가 아닙니다.", 400),
    REQUIRED_RESERVATION_MEMBER_CERTIFICATE("REQUIRED_RESERVATION_MEMBER_CERTIFICATE", "예약자 인증번호를 입력해주세요", 400),
    INVALID_RESERVATION_COMPANION_INFO("INVALID_RESERVATION_COMPANION_INFO", "내장객 정보가 일치하지 않습니다.", 400),
    FAIL_DECODE("FAIL_DECODE", "복호화에 실패했습니다.", 400),
    FAIL_ENCODE("FAIL_ENCODE", "암호화에 실패했습니다.", 400),
    CANCELED_RESERVATION("CANCELED_RESERVATION", "취소된 예약입니다.", 400),
    NOT_FOUND_RESERVATION_COMPANION_INFO("NOT_FOUND_RESERVATION_COMPANION_INFO", "동반자 정보가 존재하지 않습니다.", 400),
    ALREADY_CHECK_IN("ALREADY_CHECK_IN", "이미 체크인이 되었습니다.", 400),
    OVER_TIME("OVER_TIME", "예약 시간이 지났습니다.", 400),
    FULL_COMPANIONS_OF_RESERVATION("FULL_COMPANIONS_OF_RESERVATION", "동반자 등록 가능 인원수를 초과하였습니다.", 400),
    DUPLICATED_HP_COMPANION("DUPLICATED_HP_COMPANION", "이미 등록된 핸드폰 번호입니다.", 400),
    COMPANION_HOST("COMPANION_HOST", "동반자 대표입니다.", 400),
    EMPTY_RESERVATION_COMPANION("EMPTY_RESERVATION_COMPANION", "동반자가 존재하지 않습니다.", 400),
    INVALID_CERTIFICATION_NUMBER("INVALID_CERTIFICATION_NUMBER", "인증 정보가 유효하지 않습니다.", 403),
    CERTIFICATION_EXPIRED("CERTIFICATION_EXPIRED", "인증 정보가 만료되었습니다.", 403),

    /* HOMEPAGE */
    DATE_REQUEST_EXCEPTION("DATE_REQUEST_EXCEPTION", "시작일자 및 마지막일자 다시 선택해주세요.", 400),
    CAPTCHA_ANSWER_REQUIRED("CAPTCHA_ANSWER_REQUIRED", "보안문자를 입력해주세요.", 400),
    CAPTCHA_ANSWER_INCORRECT("CAPTCHA_ANSWER_INCORRECT", "보안문자가 일치하지 않습니다.", 400),
    EMPTY_MEMBERSHIP("EMPTY_MEMBERSHIP", "회원권 정보를 찾을 수 없습니다.", 400),
    REQUIRED_DEPOSIT_MEMBER_GRADE("REQUIRED_DEPOSIT_MEMBER_GRADE", "예치금 회원 가입 후 예약이 가능합니다.", 400),
    MANY_DEPOSIT_MEMBERS("MANY_DEPOSIT_MEMBERS", "예치금 회원정보가 여러건이 조회되었습니다. 골프클럽으로 연락주시기 바랍니다.", 400),
    NOT_RESERVATION_TIME("NOT_RESERVATION_TIME", "예약 불가능한 티타임입니다.", 400),
    CANNOT_CHOOSE_TWO_VISIT_COUNT("CANNOT_CHOOSE_TWO_VISIT_COUNT", "2인팀 선택이 불가합니다.", 400),
    NO_PASSWORD("NO_PASSWORD", "비밀번호가 없습니다. 신규 비밀번호 생성 페이지으로 이동합니다.", 400),
    DUPLICATED_DEPOSIT_MONEY_MEMBER("DUPLICATED_DEPOSIT_MONEY_MEMBER", "중복된 예치금 회원이 존재합니다.", 400),
    PENALTY_PERIOD("PENALTY_PERIOD", "위약기간에 포함되었습니다. 예약이 불가합니다.", 400),
    DUPLICATED_RESERVATION("DUPLICATED_RESERVATION", "해당일에 예약이 존재합니다.", 400),
    REQUIRED_BENEFIT_RESERVATION("REQUIRED_BENEFIT_RESERVATION", "예약 특전 설정 값이 존재하지 않습니다.", 400),
    EXCEED_COUNT_OF_AVAILABLE_RESERVATIONS("EXCEED_COUNT_OF_AVAILABLE_RESERVATIONS", "[%s] 예약가능횟수를 초과하였습니다. 예약을 할 수 없습니다.", 400),
    NOT_FOUND_EVENT_CODE("NOT_FOUND_EVENT_CODE", "이벤트에서 지정한 요금코드가 없습니다.", 400),
    NOT_FOUND_PROMOTION_CODE("NOT_FOUND_PROMOTION_CODE", "프로모션에서 지정한 요금코드가 없습니다.", 400),
    WEB_ID_ALREADY_EXIST("WEB_ID_ALREADY_EXIST", "사용 불가능한 ID 입니다", 400),
    RE_JOIN_RESTRICTION("RE_JOIN_RESTRICTION", "홈페이지 재가입이 제한되었습니다.", 400),
    DUPLICATE_DEFAULT_VALUE("DUPLICATE_DEFAULT_VALUE", "공통코드에 기본값이 2건 이상 조회되었습니다.", 400),
    ;


    // types //
    private static final Map<String, ErrorCodeEnum> TYPES =
            unmodifiableMap(stream(values()).collect(toMap(ErrorCodeEnum::getValue, identity())));
    @Getter
    private final String value;
    @Getter
    private final String desc;
    private final Integer status;

    // constructor //
    ErrorCodeEnum(String value, String desc, Integer status) {
        this.value = value;
        this.desc = desc;
        this.status = status;
    }

    // getter //
    public static ErrorCodeEnum find(String value) {
        if (TYPES.containsKey(value)) {
            return TYPES.get(value);
        }

        throw new EnumConstantNotPresentException(ErrorCodeEnum.class, value);
    }

    // functional method //
    public int getStatus() {
        return this.status;
    }


}
