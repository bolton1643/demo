# -*- coding:utf-8 -*-

from socket import *
from time import ctime 

HOST = ''
PORT = 21596
BUFSIZ = 1024
ADDR=(HOST,PORT)

tcpServSocket = socket(AF_INET, SOCK_STREAM)
tcpServSocket.bind(ADDR)
tcpServSocket.listen(5)

while True:
	print 'waiting for connection'
	tcpCliSocket, addr = tcpServSocket.accept()
	print 'connection from:', addr

	while True:
		data = tcpCliSocket.recv(BUFSIZ)
		if not data:
			break;
		tcpCliSocket.send('%s,%s'%(ctime(),data))
			
	tcpCliSocket.close()
tcpServSocket.close()			