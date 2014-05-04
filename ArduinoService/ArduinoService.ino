#include <Ethernet.h>
#include <SPI.h>

byte mac[] = { 0x90, 0xA2, 0xDA, 0x00, 0x9B, 0x36 }; 
byte ip[] = { 192, 168, 0, 99 };
byte gateway[] = { 192, 168, 0, 99 };
byte subnet[] = { 255, 255, 255, 0 };
EthernetServer server(80);

void setup() {
  Ethernet.begin(mac, ip);
  server.begin();
}

void loop() {

EthernetClient client = server.available();    
  if (client) {
    while (client.connected()) { 
      while (client.available()) {
        Serial.print(client.read());    
      }     
      
      client.println("Bem Vindo! Arduino!");
      delay(2);
      
      while (client.available()) {
        Serial.print(client.read());    
      }      
      delay(2);
      client.stop();
      break;
    }
   while(1);
  }
}
