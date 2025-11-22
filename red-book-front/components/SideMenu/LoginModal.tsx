import {Modal, ModalBody, ModalContent, ModalFooter, ModalHeader, useDisclosure} from "@heroui/modal";
import React from "react";
import {Button} from "@heroui/button";
import {Form} from "@heroui/form";
import {Input} from "@heroui/input";
import {EyeFilledIcon, EyeSlashFilledIcon} from "@heroui/shared-icons";

export function LoginModal() {
	const {isOpen, onOpen, onOpenChange} = useDisclosure();
	const [action, setAction] = React.useState("");
	const [isVisible, setIsVisible] = React.useState(false);

	const toggleVisibility = () => setIsVisible(!isVisible);
	return (
			<>
				<Button onPress={onOpen} color="danger" radius="full" fullWidth className="font-bold mt-4"
								size="lg">
					登录
				</Button>
				<Modal isOpen={isOpen} onOpenChange={onOpenChange}>
					<ModalContent>
						{(onClose) => (
								<>
									<ModalHeader className="text-center block">邮箱登录</ModalHeader>
									<ModalBody className="flex items-center">
										<Form
												className="w-full max-w-xs flex flex-col gap-4"
												onReset={() => setAction("reset")}
												onSubmit={(e) => {
													e.preventDefault();
													let data = Object.fromEntries(new FormData(e.currentTarget));

													setAction(`submit ${JSON.stringify(data)}`);
												}}
										>
											<Input
													isRequired
													errorMessage="Please enter a valid email"
													label="Email"
													labelPlacement="outside"
													name="email"
													type="email"
											/>
											<Input
													isRequired
													className="max-w-xs"
													labelPlacement="outside"
													endContent={
														<button
																aria-label="toggle password visibility"
																className="focus:outline-solid outline-transparent"
																type="button"
																onClick={toggleVisibility}
														>
															{isVisible ? (
																	<EyeSlashFilledIcon className="text-2xl text-default-400 pointer-events-none" />
															) : (
																	<EyeFilledIcon className="text-2xl text-default-400 pointer-events-none" />
															)}
														</button>
													}
													label="Password"
													type={isVisible ? "text" : "password"}
											/>
											<div className="flex gap-2 justify-center w-full">
												<Button type="reset" variant="flat">
													Reset
												</Button>
												<Button color="primary" type="submit">
													Submit
												</Button>
											</div>
											{action && (
													<div className="text-small text-default-500">
														Action: <code>{action}</code>
													</div>
											)}
										</Form>
									</ModalBody>
									<ModalFooter>
									</ModalFooter>
								</>
						)}
					</ModalContent>
				</Modal>
			</>
	);
}