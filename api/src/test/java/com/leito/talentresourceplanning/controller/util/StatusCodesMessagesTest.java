package com.leito.talentresourceplanning.controller.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusCodesMessagesTest {

    @Test
    public void testStatusCodesMessages() {
        // 200s
        assertEquals(StatusCodesMessages.STATUS_CODE_200, "Success");

        // 400s
        assertEquals(StatusCodesMessages.STATUS_CODE_400, "Bad request");
        assertEquals(StatusCodesMessages.STATUS_CODE_404, "Not found");
        assertEquals(StatusCodesMessages.STATUS_CODE_409, "Conflicts");

        // 500s
        assertEquals(StatusCodesMessages.STATUS_CODE_500, "Server error");
    }

}