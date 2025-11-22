"use client"
import React from "react";
import {Button} from "@heroui/button";
import {Avatar} from "@heroui/avatar";
import {BellIcon, CirclePlusIcon, HouseIcon, MenuIcon} from "@/components/icons";
import {usePathname, useRouter} from "next/navigation";
import {useCallback, useEffect} from "react";
import {Link} from "@heroui/link";
import clsx from "clsx";
import {link as linkStyles} from "@heroui/theme";

import NextLink from "next/link";
import {Dropdown, DropdownItem, DropdownMenu, DropdownSection, DropdownTrigger} from "@heroui/dropdown";
import {Modal, ModalBody, ModalContent, ModalFooter, ModalHeader, useDisclosure} from "@heroui/modal";
import {LoginModal} from "@/components/SideMenu/LoginModal";

export default function SideMenu() {
	const pathname = usePathname()
	const router = useRouter();
	return (
			<div className="flex basis-1/5 flex-col gap-2 mr-6">

				<Button startContent={<HouseIcon/>} radius="full" fullWidth className="flex justify-start font-bold "
								onPress={() => router.push("/example")}
								size="lg" variant={pathname.startsWith("/example") ? "flat" : "light"}>
					发现
				</Button>
				<Button startContent={<HouseIcon/>} radius="full" fullWidth className="flex justify-start font-bold "
								onPress={() => router.push("/add")}
								size="lg" variant={pathname.startsWith("/add") ? "flat" : "light"}>
					添加
				</Button>
				<Button startContent={<BellIcon/>} color="default" radius="full" fullWidth
								className="flex justify-start font-bold"
								onPress={() => router.push("/bell")}
								size="lg" variant={pathname.startsWith("/bell") ? "flat" : "light"}>

					通知
				</Button>
				<Button startContent={<Avatar size="sm" src="/favicon.ico"/>} color="default" radius="full" fullWidth
								onPress={() => router.push("/me")}
								className="flex justify-start font-bold"
								size="lg" variant={pathname.startsWith("/me") ? "flat" : "light"}>
					我
				</Button>


				<LoginModal></LoginModal>

				<div className="border border-gray-200 dark:border-gray-700 rounded-lg p-4 mt-2">
					<div className="mb-2">马上登录即可</div>
					<div className="mb-1 text-[#999999] text-sm">刷到更懂你的优质内容</div>
					<div className="mb-1 text-[#999999] text-sm">搜索最新种草、拔草信息</div>
					<div className="mb-1 text-[#999999] text-sm">查看收藏、点赞笔记</div>
					<div className="text-[#999999] text-sm">与他人更好地互动、交流</div>
				</div>


				<Dropdown>
					<DropdownTrigger>
						<Button color="default" radius="full" variant="light" fullWidth
										className="flex justify-start font-bold mt-auto"
										size="lg" startContent={<MenuIcon/>}>
							更多
						</Button>
					</DropdownTrigger>
					<DropdownMenu aria-label="Dropdown menu with description" variant="faded">
						<DropdownSection showDivider>
							<DropdownItem
									key="about"
									className="cursor-not-allowed"
							>
								关于小红书
							</DropdownItem>
							<DropdownItem
									key="privacy"
									className="cursor-not-allowed"
							>
								隐私、协议
							</DropdownItem>
							<DropdownItem
									key="help"
									className="cursor-not-allowed"
							>
								帮助与客服
							</DropdownItem>
						</DropdownSection>
						<DropdownSection title="访问方式">
							<DropdownItem
									key="shortcut"
									className="cursor-not-allowed"
							>
								键盘快捷键
							</DropdownItem>
							<DropdownItem
								key="desktop"
								className="cursor-not-allowed"
						>
							添加小红书到桌面
						</DropdownItem>
							<DropdownItem
								key="window"
								className="cursor-not-allowed"
						>
							打开小窗模式
						</DropdownItem>
						</DropdownSection>
					</DropdownMenu>
				</Dropdown>

			</div>
	)
}

