#include <SPI.h>
#include <Ethernet.h>

byte mac[] = { 0x90, 0xA2, 0xDA, 0x00, 0x9B, 0x36 };
byte ip[] = { 192, 168, 0, 99 };
byte gateway[] = { 192, 168, 0, 1 };
byte subnet[] = { 255, 255, 255, 0 };
EthernetServer server(80);

void setup() {
  Serial.begin(9600);
  Ethernet.begin(mac, ip, gateway, subnet);
  Serial.println("Iniciando o servidor...");
}

void loop() {
  EthernetClient client = server.available();
  if (client) {
    String clientMsg = "";
    while (client.connected()) {
      if (client.available()) {
        char c = client.read();      
        clientMsg+=c;
        if (c == '\n') {
          Serial.println("Mensagem do cliente: " +clientMsg);
          client.println("Mensagem de resposta:"+clientMsg);
          clientMsg = "";
        }
      }
    }
    delay(1);
    client.stop();
  }
}
