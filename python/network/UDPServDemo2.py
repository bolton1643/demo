# -*- coding:utf-8 -*-

from socket import *
from time import ctime

HOST = ''
PORT = 21597
BUFSIZ = 1024
ADDR=(HOST,PORT)

udpServSock = socket(AF_INET,SOCK_DGRAM)
udpServSock.bind(ADDR)

while True:
	print 'waiting for message'
	data,addr = udpServSock.recvfrom(BUFSIZ)
	udpServSock.sendto('[%s],%s'%(ctime(),data),addr)

udpServSock.close()	