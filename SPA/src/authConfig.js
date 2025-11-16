// src/authConfig.js

import { LogLevel } from '@azure/msal-browser';

export const msalConfig = {
    auth: {
        /**
         * GÖREV 4'ten (App Registration) aldığınız
         * 'Uygulama (istemci) Kimliği' (Application (client) ID) değeriniz.
         */
        clientId: 'bb7b60c4-c0e4-4fbd-9be3-7f53f3f823e7', // Bu ID doğru

        /**
         * ---- DÜZELTME BURADA ----
         * External ID (CIAM) için doğru format Tenant ADI kullanır, ID değil.
         * Artık flow'un doğru yerde (External ID) olduğu için bu çalışacak.
         */
        authority: 'https://FurkanHWCustTenant.ciamlogin.com/',

        /**
         * ---- DÜZELTME BURADA ----
         * Projemiz '/callback' yolunu bekliyor.
         * 'http://localhost:3000' (yol olmadan) eksik kalır.
         */
        redirectUri: 'http://localhost:3000/callback', 
        
        postLogoutRedirectUri: '/', 
        navigateToLoginRequestUrl: false, 
    },
    cache: {
        cacheLocation: 'sessionStorage', 
        storeAuthStateInCookie: false, 
    },
    system: {
        loggerOptions: {
            loggerCallback: (level, message, containsPii) => {
                if (containsPii) {
                    return;
                }
                // Hata ayıklama için konsol günlüklerini açabilirsin
                // console.log(message);
            },
            logLevel: LogLevel.Info,
            piiLoggingEnabled: false,
        },
    },
};

export const loginRequest = {
    scopes: ['openid', 'offline_access'],
    
    /**
     * ---- DÜZELTME BURADA ----
     * Hem Tenant Adı formatını hem de
     * portalda küçük harfle oluşturduğumuz 'loginflow' adını kullanıyoruz.
     */
    authority: 'https://FurkanHWCustTenant.ciamlogin.com/loginflow'
};