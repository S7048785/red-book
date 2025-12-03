import { z } from 'zod';

export const loginSchema = z.object({
  email: z.string().min(1, '请输入邮箱地址').email('请输入有效的邮箱地址'),
  password: z.string()
    .min(1, '请输入密码')
    .min(6, '密码长度不能少于6位')
    .max(20, '密码长度不能超过20位')
});

export type LoginFormData = z.infer<typeof loginSchema>;