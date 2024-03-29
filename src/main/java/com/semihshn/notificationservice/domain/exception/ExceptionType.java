package com.semihshn.notificationservice.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {
    GENERIC_EXCEPTION(1, "Bilinmeyen bir sorun oluştu"),

    NOTIFICATION_DATA_NOT_FOUND(1001, "Bildirim bulunamadı"),
    CONTACT_INFO_DATA_NOT_FOUND(1002, "İletişim bilgileri bulunamadı"),

    COLLECTION_SIZE_EXCEPTION(2001, "Liste boyutları uyuşmuyor"),
    MAIL_EXISTS(2002, "Bu mail adresi kullanılmaktadır"),

    CREDIT_SCORE_INSUFFICIENT(3001, "Kredi skorunuz yetersiz"),

    AUTHENTICATION_ERROR(4001, "Yetkiniz yok"),

    MAIL_ERROR(5002, "Mail gönderirken hata ile karşılaşıldı");;

    private final Integer code;
    private final String message;
}
