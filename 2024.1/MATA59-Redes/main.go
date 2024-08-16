package main

import (
	"fmt"
	"net"
	"os"
	"strings"
)

func main() {
	var address []string
	for _, arg := range os.Args[1:] {
		str := strings.TrimPrefix(arg, "http://")
		address = append(address, str)
	}
	if len(address) == 0 {
		address = append(address, "www.msn.com", "www.google.com", "www.globo.com")
	}

	for _, addr := range address {
		conn, err := net.Dial("tcp", fmt.Sprintf("%s:80", addr))
		if err != nil {
			panic(err)
		}
		defer conn.Close()

		message := fmt.Sprintf("GET / HTTP/1.1\r\nHost: %s\r\n\r\n", addr)

		_, err = conn.Write([]byte(message))
		if err != nil {
			panic(err)
		}

		buffer := make([]byte, 1024)
		_, err = conn.Read(buffer)
		if err != nil {
			fmt.Println(err)
		}

		fmt.Println("Resposta: ", string(buffer))

		fmt.Println("Endereços: ", addr)
	}
}

// func main() {
// 	var address []string
// 	for _, arg := range os.Args[1:] {
// 		str := strings.TrimPrefix(arg, "http://")
// 		address = append(address, str)
// 		//address = append(address, arg)
// 	}

// 	for _, addr := range address {
// 		ip, err := net.ResolveIPAddr("ip", addr)
// 		if err != nil {
// 			panic(err)
// 		}

// 		socket, err := syscall.Socket(syscall.AF_INET, syscall.SOCK_STREAM, syscall.IPPROTO_TCP)
// 		if err != nil {
// 			panic(err)
// 		}

// 		err = syscall.Connect(socket, &syscall.SockaddrInet4{
// 			Port: 80,
// 			Addr: [4]byte(ip.IP.To4()),
// 		})
// 		if err != nil {
// 			syscall.Close(socket)
// 			panic(err)
// 		}

// 		defer syscall.Close(socket)

// 		message := fmt.Sprintf("GET / HTTP/1.1\r\nHost: %s\r\n\r\n", addr)

// 		_, err = syscall.Write(socket, []byte(message))
// 		if err != nil {
// 			panic(err)
// 		}

// 		buffer := make([]byte, 1024)
// 		_, err = syscall.Read(socket, buffer)
// 		if err != nil {
// 			panic(err)
// 		}

// 		fmt.Println("Resposta: ", string(buffer))
// 	}
// }
