"use client"
import { Link } from "@heroui/link";
import { Snippet } from "@heroui/snippet";
import { Code } from "@heroui/code";
import { button as buttonStyles } from "@heroui/theme";

import { siteConfig } from "@/config/site";
import { title, subtitle } from "@/components/primitives";
import { GithubIcon } from "@/components/icons";
import {Button} from "@heroui/button";
import {Avatar} from "@heroui/avatar";
import {useState} from "react";
import {extendVariants} from "@heroui/system";

const menuList = [
	{
		channelId: "home_recommend",
		label: "推荐"
	},
	{
		channelId: "home_fashion_v3",
		label: "穿搭"
	},
	{
		channelId: "home_food_v3",
		label: "美食"
	},
	{
		channelId: "home_cosmetics_v3",
		label: "彩妆"
	},
	{
		channelId: "home_movie_and_tv_v3",
		label: "影视"
	},
	{
		channelId: "home_career_v3",
		label: "职场"
	},
	{
		channelId: "home_love_v3",
		label: "情感"
	},
]


export default function ExamplePage() {
	const [selectedMenu, setSelectedMenu] = useState("home_recommend")
	return (
			<div className="">
				<ul className="flex gap-2">
					{
						menuList.map((item) => {
							return (
									<li key={item.channelId}>
										<Button radius="full" fullWidth
												// 根据选中状态设置variant属性
														variant={selectedMenu === item.channelId ? "flat" : "light"}
												// 或者添加点击事件处理函数
														onPress={() => setSelectedMenu(item.channelId)}
														className={selectedMenu === item.channelId ? "font-bold text-md" : "text-md"} >
											{item.label}
										</Button>
									</li>
							)
						})
					}
				</ul>
			</div>
	);
}