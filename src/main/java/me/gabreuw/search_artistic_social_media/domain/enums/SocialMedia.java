package me.gabreuw.search_artistic_social_media.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SocialMedia {

    INSTAGRAM(
            "instagram",
            "https://www.instagram.com/"
    ) {
        @Override
        public String formatQuery(String username) {
            return INSTAGRAM.NAME + " " + username;
        }
    },
    SOUND_CLOUD(
            "soundcloud",
            "https://soundcloud.com/"
    ) {
        @Override
        public String formatQuery(String username) {
            return SOUND_CLOUD.NAME + " " + username;
        }
    };

    private final String NAME;
    private final String BASE_URL;

    public abstract String formatQuery(String username);

}
