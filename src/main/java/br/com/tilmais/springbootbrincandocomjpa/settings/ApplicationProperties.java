package br.com.tilmais.springbootbrincandocomjpa.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@ConfigurationProperties(prefix = "application")
@Validated
public class ApplicationProperties {

    private String name;
    private String description;
    private String version;

    @Valid
    private Token token = new Token();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public class Token {

        private Long durationInMilliseconds;

        @NotBlank
        private String key;

        @NotBlank
        private String header;

        @NotBlank
        private String prefix;

        @NotBlank
        private String claimsName;

        public Long getDurationInMilliseconds() {
            return durationInMilliseconds;
        }

        public void setDurationInMilliseconds(Long durationInMilliseconds) {
            this.durationInMilliseconds = durationInMilliseconds;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getClaimsName() {
            return claimsName;
        }

        public void setClaimsName(String claimsName) {
            this.claimsName = claimsName;
        }
    }
}
