# -*- coding:utf-8 -*-

from socket import *

HOST='127.0.0.1'
PORT=21597
BUFSIZ=1024
ADDR=(HOST,PORT)

udpClient=socket(AF_INET,SOCK_DGRAM)

while True:
    data = raw_input('>')
    if not data:
       break
    udpClient.sendto(data,ADDR)
    d,addr = udpClient.recvfrom(BUFSIZ)
    print d,addr

udpClient.close()	
