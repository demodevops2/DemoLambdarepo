package com.hsbc.auth.service;

import java.util.Date;

import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.GetIdRequest;
import com.amazonaws.services.cognitoidentity.model.GetIdResult;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenRequest;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenResult;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import com.amazonaws.services.securitytoken.model.Credentials;

public class TestAWSCognitoIdentityProvider {

  /**
  As far a
  * @param args
  */

  /*public static void main(String[] args) {
	  String client_id = "48te0qlervfpp6t0lg4n3m7ugb";
	  String redirect_uri = "https://localhost:8443/HelloWorldJSP/callback.html";
	  String restUrl = "https://hsbcuser.auth.ap-southeast-2.amazoncognito.com/oauth2/authorize?&response_type=token&client_id="+client_id+"&redirect_uri="+redirect_uri+"&state=STATE&scope=aws.cognito.signin.user.admin";
    // initialize the Cognito identity client with a set
    // of anonymous AWS credentials
    AmazonCognitoIdentity identityClient = new AmazonCognitoIdentityClient(new AnonymousAWSCredentials());
    identityClient.setEndpoint("https://cognito-identity.ap-southeast-2.amazonaws.com");

    GetIdRequest idRequest = new GetIdRequest();
    idRequest.setAccountId("967958050410");
    idRequest.setIdentityPoolId("ap-southeast-2:32a85510-63a4-456d-beb5-09f42aa45181");
    GetIdResult idResp = identityClient.getId(idRequest);

    String identityId = idResp.getIdentityId();
    System.out.println("identityId:    ******"+identityId);
    GetOpenIdTokenRequest tokenRequest = new GetOpenIdTokenRequest();
    tokenRequest.setIdentityId(identityId);
    GetOpenIdTokenResult tokenResp = identityClient.getOpenIdToken(tokenRequest);
    String openIdToken = tokenResp.getToken();
    System.out.println("openIdToken:    ******"+openIdToken);
    AWSSecurityTokenService stsClient = new AWSSecurityTokenServiceClient(new AnonymousAWSCredentials());

    AssumeRoleWithWebIdentityRequest stsReq = new AssumeRoleWithWebIdentityRequest();
    stsReq.setRoleArn("arn:aws:iam::967958050410:role/Cognito_HSBCIdentityPoolUnauth_Role");
    stsReq.setWebIdentityToken(openIdToken);
    stsReq.setRoleSessionName("AppTestSession");

    AssumeRoleWithWebIdentityResult stsResp = stsClient.assumeRoleWithWebIdentity(stsReq);
    Credentials stsCredentials = stsResp.getCredentials();

    AWSSessionCredentials sessionCredentials = new BasicSessionCredentials(
      stsCredentials.getAccessKeyId(),
      stsCredentials.getSecretAccessKey(),
      stsCredentials.getSessionToken()
    );
    Date sessionCredentialsExpiration = stsCredentials.getExpiration();

    System.out.println("Acccess Key:    ******"+sessionCredentials.getAWSAccessKeyId());

    String bucketName = "Existing bucket name";
    String keyName = "cognitokey";
    String uploadFileName = "File name with path";
    AmazonS3 s3client = new AmazonS3Client(sessionCredentials);
    s3client.setEndpoint("Provide S3 endpoint");

    File file = new File(uploadFileName);
    s3client.putObject(new PutObjectRequest(bucketName, keyName, file));
  }*/
}