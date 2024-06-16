package org.generation.italy.EpicTrip.dto;

public class TokenResponseDto {
    private String token;
    private String errorMessage;

    public static class TokenResponseDtoBuilder{
        private String token;
        private String errorMessage;
        public TokenResponseDtoBuilder  setToken(String token){
            this.token=token;
            return this;
        }
        public TokenResponseDtoBuilder setErrorMessage(String errorMessage){
            this.errorMessage=errorMessage;
            return this;
        }
        public TokenResponseDto build(){
            TokenResponseDto dto=new TokenResponseDto();
            if(token!= null){
                dto.token=token;
            }
            if(errorMessage!=null){
                dto.errorMessage=errorMessage;
            }
            return dto;
        }
    }
    public static TokenResponseDtoBuilder builder(){
        return new TokenResponseDtoBuilder();
    }

    public String getToken() {
        return token;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
