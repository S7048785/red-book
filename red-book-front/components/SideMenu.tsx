"use client"
import {Button} from "@heroui/button";
import {Avatar} from "@heroui/avatar";
import {BellIcon, CirclePlusIcon, HouseIcon} from "@/components/icons";
import {usePathname, useRouter} from "next/navigation";
import {useCallback, useEffect} from "react";
import {Link} from "@heroui/link";
import clsx from "clsx";
import { link as linkStyles } from "@heroui/theme";

import NextLink from "next/link";

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


				<Button startContent={<BellIcon/>} color="default" radius="full" fullWidth className="flex justify-start font-bold"
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
				<Button color="danger" radius="full" fullWidth className="font-bold mt-4"
								size="lg">
					登录
				</Button>

				<div className="border border-gray-200 rounded-lg p-4 mt-2">
					<div className="mb-2">马上登录即可</div>
					<div className="mb-1 text-[#999999] text-sm">刷到更懂你的优质内容</div>
					<div className="mb-1 text-[#999999] text-sm">搜索最新种草、拔草信息</div>
					<div className="mb-1 text-[#999999] text-sm">查看收藏、点赞笔记</div>
					<div className="text-[#999999] text-sm">与他人更好地互动、交流</div>
				</div>
			</div>
	)
}