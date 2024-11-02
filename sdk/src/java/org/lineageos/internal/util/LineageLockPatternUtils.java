/*
 * SPDX-FileCopyrightText: 2015 The CyanogenMod Project
 * SPDX-License-Identifier: Apache-2.0
 */
package org.lineageos.internal.util;

import android.content.Context;

import com.android.internal.widget.LockPatternUtils;

import lineageos.providers.LineageSettings;

public class LineageLockPatternUtils extends LockPatternUtils {
    public LineageLockPatternUtils(Context context) {
        super(context);
    }

    public boolean shouldPassToSecurityView(int userId) {
        return getBoolean(LineageSettings.Secure.LOCK_PASS_TO_SECURITY_VIEW, false, userId);
    }

    public void setPassToSecurityView(boolean enabled, int userId) {
        setBoolean(LineageSettings.Secure.LOCK_PASS_TO_SECURITY_VIEW, enabled, userId);
    }
}
