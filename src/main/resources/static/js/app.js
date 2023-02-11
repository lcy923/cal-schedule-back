const crypto = require("crypto")

function base64(json) {
    const stringified = JSON.stringify(json)
    //json 을 문자화
    const base64Encoded = Buffer.from(stringified).toString("base64")
    //문자열화 된 JSON을 Base64로 인코딩
    const paddingRemoved = base64Encoded.replaeAll("=","")
    //Base 64 의 Padding(= or ==)을 제거

    return paddingRemoved
}

const header = {
    alg: "HS256",
    typ: "JWT",
}

const encodedHeader = base64(header)
// eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
//단순히 header JSON을 base64 인코딩

const payload = {
    email: "lcy923@naver.com",
    name: "cylee",
    isAdmin: true,
}

const encodedPayload = base64(payload)
// eyJlbWFpbCI6ImRldmh1ZGlAZ21haWwuY29tIiwibmFtZSI6Ikh1ZGkiLCJpc0FkbWluIjp0cnVlfQ
//Header 와 마찬가지로 payload JSON 을 base64 인코딩

const signature = crypto
    .createHmac("sha256", "secret_key")
    .update(`${encodedHeader}.${encodedPayload}`)
    .digest("base64")
    .replace("=","")

const jwt = `${encodedHeader}.${encodedPayload}.${signature}`
